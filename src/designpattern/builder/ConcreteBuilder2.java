package designpattern.builder;

/**
 * 具体建造者类，建造的对象时Product，通过build使Product完善
 * 
 * @author liu yuning
 *
 */
public class ConcreteBuilder2 extends Builder {

    private Product product = new Product();

    @Override
    public void buildPartA() {
	product.add("部件X");
    }

    @Override
    public void buildPartB() {
	product.add("部件Y");
    }

    @Override
    public Product getBuildResult() {
	return product;
    }

}
