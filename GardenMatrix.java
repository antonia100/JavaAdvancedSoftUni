//        You will be given N and M – integers, indicating the dimensions of the square garden.
//        The garden is empty at the beginning – it has no flowers. The gardener wants every place for a flower to be presented with a zero (0) when it is empty.
//        After you’ve finished creating the garden, you will start receiving two integers – Row and Column, separated by a single space – which represent the position at which
//        the gardener currently plants a flower. This happens until you receive the command “Bloom Bloom Plow”. When you receive that input, all planted flowers should bloom.
//        The flowers are magical. When a flower blooms it instantly blooms flowers to all places to its left, right, up, and down, increasing their value with 1.
//        Flowers can bloom multiple times, and each time the flower blooms – it becomes more and more beautiful, which means its value increases.
//        The blooming of flowers is done from the top-left corner of the garden to the bottom-right one.
//        Note: If one flower blooms and affects several places, and then another flower blooms and affects one of the first flower’s affected places,
//        it does NOT override their values with 1 again. Instead it blooms them one more time – increasing their value with 1.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GardenMatrix {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] rowsAndCols = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] garden = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                garden[row][col] = 0;
            }
        }

        String command = reader.readLine();
        List<String> commandsList = new ArrayList<>();

        while (!command.equals("Bloom Bloom Plow")) {
            commandsList.add(command);
            command = reader.readLine();
        }

        int[][] commands = new int[commandsList.size()][2];

        //fill commands matrix with the data from commandsList strings
        for (String s : commandsList) {
            String[] sArr = s.split("\\s+");
            commands[commandsList.indexOf(s)][0] = Integer.valueOf(sArr[0]);
            commands[commandsList.indexOf(s)][1] = Integer.valueOf(sArr[1]);
        }


        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                for (int rowC = 0; rowC < commands.length; rowC++) {

                    if (row == commands[rowC][0] && col == commands[rowC][1]) {
                        //fill row
                        garden[row][col] += 1;
                        for (int x = 0; x < cols; x++) {
                            if (x != col) {
                                garden[row][x] += 1;
                            }
                        }
                        //fill col
                        for (int y = 0; y < rows; y++) {
                            if (y != row) {
                                garden[y][col] += 1;
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(garden[i][j] + " ");

            }
            System.out.println();
        }

    }
}
