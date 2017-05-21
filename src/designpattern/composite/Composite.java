package designpattern.composite;

import java.util.ArrayList;
import java.util.List;

import util.StringUtil;

/**
 * 定义有枝节点行为，用来存储子部件
 * 
 * @author liu yuning
 *
 */
public class Composite extends Component {
    private List<Component> children = new ArrayList<Component>();

    public Composite(String name) {
	super(name);
    }

    @Override
    public void add(Component component) {
	children.add(component);
    }

    @Override
    public void remove(Component component) {
	children.remove(component);
    }

    @Override
    public void display(int depth) {
	// 显示其枝节点名称，并对其下级进行遍历
	System.out.println(StringUtil.repeatableString("-", depth) + this.name);

	for (Component component : children) {
	    component.display(depth + 2);
	}

    }

}
