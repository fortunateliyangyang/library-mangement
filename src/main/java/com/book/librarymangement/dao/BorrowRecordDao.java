package com.book.librarymangement.dao;

import com.book.librarymangement.entity.BorrowRecord;
import com.book.librarymangement.entity.BorrowRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BorrowRecordDao {
    long countByExample(BorrowRecordExample example);

    int deleteByExample(BorrowRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BorrowRecord record);

    int insertSelective(BorrowRecord record);

    List<BorrowRecord> selectByExample(BorrowRecordExample example);

    BorrowRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BorrowRecord record, @Param("example") BorrowRecordExample example);

    int updateByExample(@Param("record") BorrowRecord record, @Param("example") BorrowRecordExample example);

    int updateByPrimaryKeySelective(BorrowRecord record);

    int updateByPrimaryKey(BorrowRecord record);
}