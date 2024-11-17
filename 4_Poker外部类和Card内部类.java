import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Poker {

    // 定义花色和点数数组
    private String[] suits = {"S", "H", "C", "D"}; // 使用字母表示花色
    private String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"}; // 点数
    
    // 定义一副扑克牌的数组
    private List<Card> deck;

    // 构造方法，初始化一副牌
    public Poker() {
        deck = new ArrayList<>();
        // 构造扑克牌，每张牌由花色和点数组合
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(new Card(suit, rank));
            }
        }
    }

    // 洗牌方法，使用Math.random()来打乱扑克牌顺序
    public void shuffle() {
        Collections.shuffle(deck); // 使用Collections的shuffle方法打乱顺序
    }

    // 发牌方法
    public Card deal() {
        if (!deck.isEmpty()) {
            return deck.remove(deck.size() - 1); // 从扑克牌的末尾发牌
        } else {
            return null; // 如果牌已经发完，返回null
        }
    }

    // 内部类Card，表示扑克牌的每一张牌
    public class Card {
        private String suit; // 花色
        private String rank; // 点数

        // 构造方法
        public Card(String suit, String rank) {
            this.suit = suit;
            this.rank = rank;
        }

        // 打印牌的信息
        public void printCard() {
            System.out.println(rank + suit); // 输出牌的点数和花色
        }

        // 获取花色
        public String getSuit() {
            return suit;
        }

        // 获取点数
        public String getRank() {
            return rank;
        }
    }

    // 测试类，包含main方法
    public static void main(String[] args) {
        Poker poker = new Poker();  // 创建一副牌

        System.out.println("初始牌顺序:");
        // 打印初始顺序的扑克牌
        for (int i = 0; i < 5; i++) { // 先显示五张牌
            poker.deal().printCard();
        }

        System.out.println("\n洗牌后:");

        // 洗牌
        poker.shuffle();
        
        // 打印洗牌后的扑克牌顺序
        for (int i = 0; i < 5; i++) { // 继续显示五张牌
            poker.deal().printCard();
        }
    }
}
