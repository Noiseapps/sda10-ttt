package pl.sda.ttt;

import java.util.Scanner;

public class TicTacToeMain {

    private final static Scanner scanner = new Scanner(System.in);
    final Field[][] board = new Field[3][3];


    public static void main(String[] args) {
        new TicTacToeMain().run();
    }

    private void run() {
        System.out.println("Enter player 1 name");
        String player1Name = scanner.nextLine();

        System.out.println("Enter player 2 name");
        String player2Name = scanner.nextLine();

        Field player1Field = Field.randomField();
        Player player1 = new Player(player1Name, player1Field);
        Player player2 = new Player(player2Name, Field.otherThan(player1Field));

        Player currentPlayer = player1;

        player1.setNextPlayer(player2);
        player2.setNextPlayer(player1);

        System.out.println("Player 1:");
        System.out.println(player1);

        System.out.println("Player 2");
        System.out.println(player2);
        drawBoard();
        while (true) { // main game loop
            System.out.printf("It's %s turn\nEnter where to put your sign:\n", currentPlayer);
            int[] coordinates = getCoordinates();
            board[coordinates[0]][coordinates[1]] = currentPlayer.getField();
            drawBoard();
            if (checkWin()) {
                System.out.printf("Congrats, player %s wins the game!!!", currentPlayer);
                return;
            }
            if (checkDraw()) {
                System.out.println("Uhhh, it's a draw, nobody wins");
                return;
            }
            currentPlayer = currentPlayer.getNextPlayer();
        }
    }

    private boolean checkDraw() {
        for (Field[] fields : board) {
            for (Field field : fields) {
                if (field == null) return false;
            }
        }
        return true;
    }

    private void drawBoard() {
        final StringBuilder builder = new StringBuilder("Current board state:\n\n");
        for (Field[] fields : board) {
            for (Field field : fields) {
                builder.append("|").append(field != null ? field : " ");
            }
            builder.append("|").append("\n");
        }
        final String board = builder.toString();
        System.out.println(board);
    }

    boolean checkWin() {
        return checkHorizontal() || checkVertical() || checkDiagonal();
    }

    private boolean checkDiagonal() {
        boolean same = true;
        Field firstField = board[0][0];
        for (int i = 0; i < board.length; i++) {
            if (firstField != board[i][i] || firstField == null) same = false;
        }
        if (same) return true;

        same = true;
        int topBound = board.length - 1;
        firstField = board[topBound][0];
        for (int i = 0; i < board.length; i++) {
            if (firstField != board[topBound - i][i] || firstField == null) same = false;
        }

        return same;
    }

    private boolean checkVertical() {
        for (int i = 0; i < board.length; i++) {
            boolean same = true;
            Field firstField = board[0][i];
            for (int j = 0; j < board.length; j++) {
                if (firstField != board[j][i] || firstField == null) same = false;
            }
            if (same) {
                return true;
            }
        }
        return false;
    }

    private boolean checkHorizontal() {
        for (Field[] fields : board) {
            boolean same = true;
            Field firstField = fields[0];
            for (Field field : fields) {
                if (firstField != field || firstField == null) same = false;
            }
            if (same) {
                return true;
            }
        }
        return false;
    }

    private int[] getCoordinates() {
        while (true) {
            try {
                System.out.println("Enter coordinates in form: x,y");
                String coordinates = scanner.nextLine();
                String[] split = coordinates.split(",");
                checkValidMove(split);
                return getIntValues(split);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getLocalizedMessage());
            }
        }
    }

    private int[] getIntValues(String[] line) {
        int x = Integer.parseInt(line[0]);
        int y = Integer.parseInt(line[1]);
        return new int[]{y, x};
    }

    private void checkValidMove(String[] line) {
        if (line.length != 2) {
            throw new IllegalArgumentException("Incorrect format");
        }
        int[] fields = getIntValues(line);
        if (fields[0] < 0 || fields[0] >= board.length) {
            throw new IllegalArgumentException("Incorrect x coordinate");
        }
        if (fields[1] < 0 || fields[1] >= board[fields[0]].length) {
            throw new IllegalArgumentException("Incorrect y coordinate");
        }
        if (board[fields[0]][fields[1]] != null) {
            throw new IllegalArgumentException("This field is already taken");
        }
    }
}
