import java.util.List;

import org.springframework.stereotype.Repository;

import com.errbod.temp.domain.ErrBoard;

@Repository
public interface ErrBoardMapper {
	List<ErrBoard> selectErrList();
}
