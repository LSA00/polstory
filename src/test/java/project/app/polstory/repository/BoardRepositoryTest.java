package project.app.polstory.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import project.app.polstory.entity.Board;

import java.util.stream.IntStream;

@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void insertDummies(){
        IntStream.rangeClosed(1,30).forEach(i->{
            Board board = Board.builder()
                    .tags("test tags " + i)
                    .title("test title " + i)
                    .build();

            boardRepository.save(board);
        });
    }
}
