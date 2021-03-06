/**
 * @program JavaBooks
 * @description: 模仿方法
 * @author: mf
 * @create: 2019/10/03 09:58
 */
/*
定义一个操作中的算法骨架，而将一些步骤延迟到子类中。模板方法使得子类可以不改变一个算法的结构即可重定义该算法的
例如：
1- 去银行办业务，银行给我们提供了一个模板就是：先取号，排对，办理业务（核心部分我们子类完成），给客服人员评分，完毕。
这里办理业务是属于子类来完成的，其他的取号，排队，评分则是一个模板。
2- 去餐厅吃饭，餐厅给提供的一套模板就是：先点餐，等待，吃饭（核心部分我们子类完成），买单
这里吃饭是属于子类来完成的，其他的点餐，买单则是餐厅提供给我们客户的一个模板。

实现一些操作时，整体步骤很固定，但是呢。就是其中一小部分容易变，这时候可以使用模板方法模式，将容易变的部分抽象出来，供子类实现。
 */

// 举个例子， 银行
abstract class BankTemplateMethod {
    // 1. 取号排队
    public void takeNumber() {
        System.out.println("取号排队...");
    }

    // 2. 每个子类不同的业务实现，各由子类来实现
    abstract void transact();

    // 3. 评价
    public void evaluate() {
        System.out.println("反馈评价...");
    }

    public void process() {
        takeNumber();
        transact();
        evaluate();
    }
}

// 具体的子类
class DrawMoney extends BankTemplateMethod {

    @Override
    void transact() {
        System.out.println("我要取款...");
    }
}

public class TemplateMode {
    public static void main(String[] args) {
        BankTemplateMethod drawMoney = new DrawMoney();
        drawMoney.process();
    }
}
