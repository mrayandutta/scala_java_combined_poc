package pizza.builder;

public enum Size {
    MEDIUM {
        public double getCost() {
            return 100;
        }
        
        public String getDescription() {
            return this.name();
        }
        
    }, LARGE {
        public double getCost() {
            return 200;
        }
        
        public String getDescription() {
            return this.name();
        }
    };
 
    public abstract double getCost();
    public abstract String getDescription();
}