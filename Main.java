import algoritm_homework;

// package seminar4;

public class Main {

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(value:4);
        tree.add(value:5);
        tree.add(value:2);
        System.out.println(tree.contains(6));
    }
}



// В домашке понадобиться: общая структура, сделать акцент больше на повороты, метод добавления пересмотреть. 
// Сделать правильную балансировку в деревьях