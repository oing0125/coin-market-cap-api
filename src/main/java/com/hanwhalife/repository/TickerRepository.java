package com.hanwhalife.repository;

import com.hanwhalife.vo.Tickers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TickerRepository extends CrudRepository<Tickers, Long> {

    @Query(nativeQuery = true, value="select * from tickers as t where t.base in (:coins) or t.target in (:coins)")
    List<Tickers> findTickersByCoin(@Param("coins") List<String> coins);
}
