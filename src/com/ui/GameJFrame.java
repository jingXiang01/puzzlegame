package com.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener , ActionListener {
    //规定表示为游戏主界面
    //创建一个二维数组
    int [][] data = new int[4][4];
    //记录空白方块的位置
    int x = 0;
    int y = 0;

    //定义一个变量，记录当前展示图片的路径
     String path = "image\\animal\\animal3\\";

     //定义一个二维数组，存储正确的数据
    int[][] win = {
             {1,5,9,13},
             {2,6,10,14},
             {3,7,11,15},
             {4,8,12,0}
     };

    int step = 0;

    //创建选项下面的条目对象
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reLoginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");

    JMenuItem accountItem = new JMenuItem("公众号");
    //创建JMenuItem的对象
    JMenuItem girl = new JMenuItem("美女");
    JMenuItem animal = new JMenuItem("动物");
    JMenuItem sport = new JMenuItem("运动");
    public GameJFrame() {
        //初始化界面
        initJFrame();
        //初始化菜单
        initJMenuBar();
        //初始化数据
        initData();
        //初始化图片
        initImage();
        //让显示出来，写在最后
        this.setVisible(true);
    }

    private void initData() {
        //1.定义一个一维数组
        int[] tempArr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        //2.打乱数组中的数据的顺序
        //遍历数组，得到每一个元素，拿着每一个元素跟随机索引上的数据进行交换
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            //获取到随机索引
            int index = r.nextInt(tempArr.length);
            //拿着遍历到的每一个数据，跟随机索引上的数据进行交换
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }
            //4.给二维数组添加数据
        for (int i = 0; i < tempArr.length; i++) {
            if(tempArr[i] == 0){
                x = i / 4;
                y = i % 4;
            }
            {
                data[i / 4][i % 4] = tempArr[i];
            }

        }

    }
        //添加图片的时候，就需要按照二维数组中管理的数据添加图片
    private void initImage() {
        //创建一个图片ImageIcon的对象
        //创建一个JLabel的对象
        //清空原本已经出现的所有图片
        this.getContentPane().removeAll();
        if(victory()){
            JLabel linklabel = new JLabel(new ImageIcon("C:\\Users\\项\\IdeaProjects\\puzzlegame\\image\\win.png"));
            linklabel.setBounds(203,283,197,173);
            this.getContentPane().add(linklabel);
        }
        JLabel stepCount = new JLabel("步数："+step);
        stepCount.setBounds(50,30,100,20);
        this.getContentPane().add(stepCount);
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                //获取当前要加载图片的序号
                int num = data[i][j];
                JLabel jLabel1 = new JLabel(new ImageIcon(path + num +".jpg"));
                //指定图片位置
                jLabel1.setBounds(105 * i + 83, 105 * j + 134, 105, 105);
                //给图片添加边框
                jLabel1.setBorder(new BevelBorder(0));
                //把管理容器添加到界面中
                this.getContentPane().add(jLabel1);

            }
        }
        //先加载的图片在上方
        ImageIcon bg = new ImageIcon("image\\background.png");
        JLabel background = new JLabel(bg);
        background.setBounds(40,40,508,560);
        this.getContentPane().add(background);

        //刷新界面
        this.getContentPane().repaint();
    }


    private void initJMenuBar() {
        //初始化菜单
        //创建整个菜单对象
        JMenuBar jMenuBar = new JMenuBar();

        //创建菜单上面的两个选项的对象（功能 关于我们）
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");
        JMenu changeImage = new JMenu("更换图片");



        //将每一个选项下面的条目添加到选项当中
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);

        changeImage.add(girl);
        changeImage.add(animal);
        changeImage.add(sport);

        //给条目绑定事件
        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);
        girl.addActionListener(this);
        animal.addActionListener(this);
        sport.addActionListener(this);
        //将菜单里面的两个选项添加到菜单当中
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);
        jMenuBar.add(changeImage);
        //给整个界面设置菜单

        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        //设置界面的宽高
        this.setSize(603,680);
        //设置界面标题
        this.setTitle("拼图单机版");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面剧中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消默认的居中放置，只有取消了才能按照XY轴的方式布置
        this.setLayout(null);
        //给真个界面添加键盘监听事件
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == 65)
        {
            this.getContentPane().removeAll();
            JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
            all.setBounds(83,134,420,420);
            this.getContentPane().add(all);
            ImageIcon bg = new ImageIcon("image\\background.png");
            JLabel background = new JLabel(bg);
            background.setBounds(40,40,508,560);
            this.getContentPane().add(background);
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //判断游戏是否胜利，如果胜利直接结束
        if(victory()){
            return;
        }
        //对上下左右进行判断
        int code = e.getKeyCode();
        if(code == 37){
            if(x == 3)
            {
                return;
            }

            //向上移动
            //把空白方块下方的数字往上移动
            //x,y表示空白 x+1 ，y
            data[x][y] = data[x+1][y];
            data[x+1][y] = 0;
            x++;
            step++;
            //调用方法按照最新的数字加载图片
            initImage();
        } else if (code == 38) {
            if(y == 3)
            {
                return;
            }
            //向左移动
            data[x][y] = data[x][y + 1];
            data[x][y+1]  = 0;
            y++;
            step++;
            initImage();
        } else if (code == 39) {
            //向下移动
            if(x == 0)
            {
                return;
            }
            data[x][y] = data[x - 1][y];
            data[x-1][y]  = 0;
            x--;
            step++;
            initImage();
        } else if (code == 40) {
            //向右移动
            if(y == 0)
            {
                return;
            }
            data[x][y] = data[x][y - 1];
            data[x][y-1]  = 0;
            y--;
            step++;
            initImage();
        } else if (code == 65) {
            initImage();
        } else if (code == 87) {
            data = new int[][]{
                    {1,5,9,13},
                    {2,6,10,14},
                    {3,7,11,15},
                    {4,8,12,0}
            };
            initImage();
        }



    }
    //判断data数组中的数据是否跟win数组中相同
    //如果全部相同，返回true, 否则返回false
    public boolean victory(){
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
               if(data[i][j] != win[i][j]) {
                   return false;
               }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == replayItem){
            //再次打乱二维数据中的数据
            //重新加载图片
            //计步器清零
            step = 0;
            initData();
            initImage();

        } else if (obj == reLoginItem) {
            //关闭当前的游戏界面
            //打开登录界面
            this.setVisible(false);
            new LoginJFrame();
        } else if (obj == closeItem) {
            //直接关闭虚拟机
            System.exit(0);
        } else if (obj == accountItem) {
            //创建一个弹框对象
            JDialog jDialog = new JDialog();
            //创建一个管理图片的容器对象
            JLabel jLabel = new JLabel(new ImageIcon("C:\\Users\\项\\IdeaProjects\\puzzlegame\\image\\about.png"));
            //设置位置和宽高
            jLabel.setBounds(0,0,258,258);
            //把图片添加到弹框中
            jDialog.getContentPane().add(jLabel);
            //弹框设置大小
            jDialog.setSize(344,344);
            //弹框置顶
            jDialog.setAlwaysOnTop(true);
            //弹框居中
            jDialog.setLocationRelativeTo(null);
            //弹框不关闭无法操作下面的界面
            jDialog.setModal(true);
            jDialog.setVisible(true);
        } else if (obj == girl) {
            int num = new Random().nextInt(12) + 1;
            path = "image\\girl\\girl"+ num +"\\";
            step = 0;
            initData();
            initImage();
        } else if (obj == animal) {
            int num = new Random().nextInt(7) + 1;
            path = "image\\animal\\animal"+ num +"\\";
            step = 0;
            initData();
            initImage();
        } else if (obj == sport) {
            int num = new Random().nextInt(9) + 1;
            path = "image\\sport\\sport"+ num +"\\";
            step = 0;
            initData();
            initImage();
        }
    }
}
