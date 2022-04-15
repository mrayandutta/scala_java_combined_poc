package pizza.builder;

public enum Topping {

	PEPPERONI {
		public double getCost() {
			return 10;
		}
		public String getDescription() {
            return this.name();
        }
	},
	CHICKEN {
		public double getCost() {
			return 20;
		}
		public String getDescription() {
            return this.name();
        }
	},
	MUSHROOM {
		public double getCost() {
			return 30;
		}
		public String getDescription() {
            return this.name();
        }
	};

	public abstract double getCost();
	public abstract String getDescription();
}