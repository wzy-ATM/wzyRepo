package com.wzy.demo.dao;

import com.wzy.demo.vo.DrawCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface DrawDao extends JpaRepository<DrawCode,Integer> {

    @Query(nativeQuery=true, value = "select * from draw_code where status = '0'")
    List<DrawCode> findByStatus();

}
