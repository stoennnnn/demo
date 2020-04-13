package src.java8.chap5;import java.util.*;import java.util.stream.Stream;import static java.util.Comparator.comparing;import static java.util.stream.Collectors.joining;import static java.util.stream.Collectors.toList;/** * @Date: 2019/12/19 21:45 * @Description: */public class Practice_5 {    public static void main(String... args) {        Trader raoul = new Trader("Raoul", "Cambridge");        Trader mario = new Trader("Mario", "Milan");        Trader alan = new Trader("Alan", "Cambridge");        Trader brian = new Trader("Brian", "Cambridge");        List<Transaction> transactions = Arrays.asList(                new Transaction(brian, 2011, 300),                new Transaction(raoul, 2012, 1000),                new Transaction(raoul, 2011, 400),                new Transaction(mario, 2012, 710),                new Transaction(mario, 2012, 700),                new Transaction(alan, 2012, 950)        );        /**         * 2011年发生的所有交易         */        List<Transaction> collect = transactions                .stream()                .filter(a -> a.getYear() == 2011)                .sorted(comparing(Transaction::getValue))                .collect(toList());        System.out.println(collect);        /**         * 交易员都在哪些城市工作过         * 1 先生成交易员list 再取出list里面的城市并去重         * 2.直接取出城市list去重         */        List<String> cities1 = transactions                .stream()                .map(Transaction::getTrader)                .collect(toList())                .stream()                .map(Trader::getCity)                .distinct()                .collect(toList());        System.out.println(cities1);        List<String> cities2 = transactions                .stream()                .map(transaction -> transaction.getTrader().getCity())                .distinct()                .collect(toList());        System.out.println(cities2);        /**         * 查找所有来自剑桥的交易员,并按姓名排序         */        List<Trader> traders= transactions.stream()                .map(Transaction::getTrader)                .filter(trader -> trader.getCity().equals("Cambridge"))                .distinct()                .sorted(comparing(Trader::getName))                .collect(toList());        /**         * 查找所有交易员姓名的字符串，并按字母排序         */        String reduce = transactions                .stream()                .map(Transaction::getTrader)                .map(Trader::getName)                .distinct()                .sorted()                .reduce("", (a, b) -> a + b);        System.out.println(reduce);        /**         * 有没有交易员是再米兰工作的         */        Optional<Boolean> milan = transactions                .stream()                .map(transaction -> transaction.getTrader().getCity().equals("milan"))                .findAny();        System.out.println(milan);        /**         * 打印再剑桥交易员的所有交易额         */        List<Integer> valus = transactions                .stream()                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))                .map(Transaction::getValue)                .collect(toList());        System.out.println(valus);        /**         * 所有交易额中最大的交易额是多少         */        Optional<Integer> max = transactions                .stream()                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))                .map(Transaction::getValue)                .reduce(Integer::max);        System.out.println(max);        /**         * 找出交易额最小的交易         * 1.通过reduce依次比较得出最小值         * 2.使用流支持的min/max方法         */        Optional<Transaction> reduce1 = transactions                .stream()                .reduce((t1, t2) -> t1.getValue() > t2.getValue() ? t2 : t1);        System.out.println(reduce1);        ///////////////////////        Optional<Transaction> min = transactions                .stream()                .min(comparing(Transaction::getValue));        System.out.println(min);        /**         * collector收集器连接字符串         */        String collect1 = transactions.stream().map(transaction -> transaction.getTrader()                .getName()).collect(joining(","));        System.out.println(collect1);        Optional<Transaction> first = transactions.stream().filter(t -> t.getValue() == 300).findFirst();        first.ifPresent(transaction -> transaction.getValue());    }}