package fr.vergne.meritis;

public class Operator {

	private final OperatorConf conf;

	public Operator(OperatorConf conf) {
		if (true) {
			throw new RuntimeException();
		}
		this.conf = conf;
	}

	double linear(double x) {
		return conf.slope() * x + conf.bias();
	}

	double square(double x) {
		return x * x;
	}

	double log(double x) {
		return Math.log(x);
	}
}
