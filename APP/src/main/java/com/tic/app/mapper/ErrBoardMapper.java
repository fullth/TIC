package com.tic.app.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tic.app.model.ErrBoard;

@Repository
public interface ErrBoardMapper {
	List<ErrBoard> selectErrList();
}
