package designpattern.builder;

/**
 * 指挥者类，用来指挥建造过程
 * 
 * @author liu yuning
 *
 */
public class Director {

    public void construct(Builder builder) {
	builder.buildPartA();
	builder.buildPartB();
    }
}
