package com.ddoongmause.persistence;

import org.springframework.data.repository.CrudRepository;

import com.ddoongmause.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {

}
