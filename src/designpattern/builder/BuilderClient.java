package designpattern.builder;

/**
 * 建造客户端
 * 
 * @author liu yuning
 *
 */
public class BuilderClient {

    public static void main(String[] args) {
	Director director = new Director();
	Builder builder1 = new ConcreteBuilder1();
	Builder builder2 = new ConcreteBuilder2();

	director.construct(builder1);
	Product product1 = builder1.getBuildResult();
	product1.show();

	director.construct(builder2);
	Product product2 = builder2.getBuildResult();
	product2.show();

    }

}
