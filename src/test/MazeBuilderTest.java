package test;

import model.MazeBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MazeBuilderTest {

    // test 4x4 for the beginner game
    @Test
    void test4x4BuildRoomMethod() {
        MazeBuilder builder = new MazeBuilder();
        Assertions.assertEquals(
                "+-+-+-+-+\n" +
                        "|P| | | |\n" +
                        "+-+-+-+-+\n" +
                        "| | | | |\n" +
                        "+-+-+-+-+\n" +
                        "| | | | |\n" +
                        "+-+-+-+-+\n" +
                        "| | | |E|\n" +
                        "+-+-+-+-+\n", String.valueOf(builder.buildRoom())
        );
    }

    // test 8x8 for the medium game
    @Test
    void test8x8BuildRoomMethod() {
        MazeBuilder builder = new MazeBuilder(8);
        Assertions.assertEquals(
                "+-+-+-+-+-+-+-+-+\n" +
                         "|P| | | | | | | |\n" +
                         "+-+-+-+-+-+-+-+-+\n" +
                         "| | | | | | | | |\n" +
                         "+-+-+-+-+-+-+-+-+\n" +
                         "| | | | | | | | |\n" +
                         "+-+-+-+-+-+-+-+-+\n" +
                         "| | | | | | | | |\n" +
                         "+-+-+-+-+-+-+-+-+\n" +
                         "| | | | | | | | |\n" +
                         "+-+-+-+-+-+-+-+-+\n" +
                         "| | | | | | | | |\n" +
                         "+-+-+-+-+-+-+-+-+\n" +
                         "| | | | | | | | |\n" +
                         "+-+-+-+-+-+-+-+-+\n" +
                         "| | | | | | | |E|\n" +
                         "+-+-+-+-+-+-+-+-+\n" , String.valueOf(builder.buildRoom())
        );
    }

    // test 15x15 for the hard game
    @Test
    void test15x15BuildRoomMethod() {
        MazeBuilder builder = new MazeBuilder(15);
        Assertions.assertEquals(
                "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n" +
                        "|P| | | | | | | | | | | | | | |\n" +
                        "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n" +
                        "| | | | | | | | | | | | | | | |\n" +
                        "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n" +
                        "| | | | | | | | | | | | | | | |\n" +
                        "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n" +
                        "| | | | | | | | | | | | | | | |\n" +
                        "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n" +
                        "| | | | | | | | | | | | | | | |\n" +
                        "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n" +
                        "| | | | | | | | | | | | | | | |\n" +
                        "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n" +
                        "| | | | | | | | | | | | | | | |\n" +
                        "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n" +
                        "| | | | | | | | | | | | | | | |\n" +
                        "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n" +
                        "| | | | | | | | | | | | | | | |\n" +
                        "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n" +
                        "| | | | | | | | | | | | | | | |\n" +
                        "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n" +
                        "| | | | | | | | | | | | | | | |\n" +
                        "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n" +
                        "| | | | | | | | | | | | | | | |\n" +
                        "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n" +
                        "| | | | | | | | | | | | | | | |\n" +
                        "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n" +
                        "| | | | | | | | | | | | | | | |\n" +
                        "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n" +
                        "| | | | | | | | | | | | | | |E|\n" +
                        "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n" , String.valueOf(builder.buildRoom())
        );
    }
}