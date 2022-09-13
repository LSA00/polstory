package project.app.polstory.dto;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//화면에서 필요한 결과는 PageResultDTO 라는 이름으로 생성한다.
@Data
public class PageResultDTO<DTO , EN> {
//다양한 곳에서 사용할 수 있도록 제네릭 타입을 이용해 DTO와 EN(Entity) 타입을 지정한다.

    private List<DTO> dtoList;
    //DTO리스트
    private int totalPage;
    //전체 페이지
    private int page;
    //현재 페이지
    private int size;
    //목록의 크기
    private int start,end;
    //시작페이지 , 끝페이지 번호
    private boolean prev,next;
    //이전 다음
    private List<Integer> pageList;
    // 페이지 번호 목록
    public  PageResultDTO(Page<EN> result, Function<EN , DTO> fn){
        //Function = 엔티티 객체들을 DTO로 변환해주는 함수
        dtoList = result.stream().map(fn).collect(Collectors.toList());

        totalPage = result.getTotalPages();

        makePageList(result.getPageable());
    }

    private void makePageList(Pageable pageable){
        this.page = pageable.getPageNumber() + 1; // 0부터 시작하므로 1을 더해준다.
        this.size = pageable.getPageSize();

        //시작번호 계산을 수월하게 하기 위해 끝 번호를 미리 계산한다.
        int tempEnd = (int)(Math.ceil(page/10.0))*10;

        start = tempEnd - 9; //화면에 10페이지씩 보여준다면 시작 번호는 무조건 끝 번호에서 9를 뺀 값이다.

        prev = start > 1;

        end = Math.min(totalPage, tempEnd);

        next = totalPage > tempEnd;

        pageList = IntStream.rangeClosed(start,end).boxed().collect(Collectors.toList());

    }
}
