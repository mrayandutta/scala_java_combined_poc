package deltalake;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkException;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.SparkSession;

/**
 * AcidTransactionWithDeltaLake is a class to illustrate how spark offer ACID Transaction with delta Lake.
 */
   public final class AcidTransactionWithDeltaLake {

    private static final Logger LOGGER = Logger.getLogger(AcidTransactionWithDeltaLake.class);
    private final static String SPARK_APPLICATION_NAME = "Spark with Delta Lake Example";
    private final static String SPARK_APPLICATION_RUNNING_MODE = "local";
    private final static String FILE_PATH = "sparkdata/deltalakedata";

    public static void main(String[] args) {
        // Turn off spark's default logger
        Logger.getLogger("org.apache").setLevel(Level.WARN);

        // Create Spark Session
        SparkSession sparkSession = SparkSession.builder().appName(SPARK_APPLICATION_NAME)
                .master(SPARK_APPLICATION_RUNNING_MODE)
                .getOrCreate();

        Dataset<Long> data = sparkSession.range(100, 200);

        //Job-1
        data.write().format("delta").save(FILE_PATH);
        LOGGER.info("records created after Job-1 "  + sparkSession.read().format("delta").load(FILE_PATH).count());
        data.show();

        //-Job-2

        try {
            Dataset<Long> overwriteData = sparkSession.range(100);
            overwriteData.map((MapFunction<Long, Integer>)
                    AcidTransactionWithDeltaLake::getInteger, Encoders.INT())
                    .write().format("delta").mode("overwrite").option("overwriteSchema", "true").save(FILE_PATH);
            overwriteData.show();
        } catch (Exception e) {
            if (e.getCause() instanceof SparkException) {
                LOGGER.warn("failed while OverWriteData into data source", e.getCause());
                LOGGER.info("records created after Job-2 "  + sparkSession.read().format("delta").load(FILE_PATH).count());
                sparkSession.read().format("delta").load(FILE_PATH).show();
            }

            throw new RuntimeException("Runtime exception!");
        }

        //close Spark Session
        sparkSession.close();
    }

    /**
     * Failed job in the middle.
     *
     * @param num number from the record.
     * @return Integer to be write in data Lake.
     */
    private static Integer getInteger(Long num) {
        if (num > 100) {
            throw new RuntimeException("Oops! Atomicity failed");
        }
        return Math.toIntExact(num);
    }
}

