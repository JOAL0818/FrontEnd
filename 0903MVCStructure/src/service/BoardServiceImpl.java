package service;

import dao.BoardDao;
import dao.BoardDaoImpl;

public class BoardServiceImpl implements BoardService {
	//service에서는 저장소를 사용 
	private BoardDao boardDao;
	
	// singleton 패턴적용

	// 생성자를 private으로 하면 다른 곳에서 new를 이용한 인스턴스 생성을 못하게 할 수 있다.
	private BoardServiceImpl() {
		//Dao 객체생성 - 생성자에게 객체를 생성한다. 
		boardDao = BoardDaoImpl.getInstance();
	}

	// static 변수로 자신의 인스턴스를 저장할 수 있는 변수를 선언
	private static BoardService boardService;

	// 인스턴스를 생성해서 리턴해주는 static 메소드 생성
	public static BoardService getInstance() { //공유한다는 의미로 sharedInstance로 쓰기도 한다.
		if (boardService == null) {
			boardService = new BoardServiceImpl();
		}
		return boardService;
	}

}
