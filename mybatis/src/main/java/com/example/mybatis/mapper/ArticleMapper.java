package com.example.mybatis.mapper;

import com.example.mybatis.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {
    @Results(id="articleResult", value={
            @Result(property="title", column="title"),
            @Result(property="description", column="description"),
            @Result(property="memberId", column="member_id")
    })
    @Select("SELECT * FROM article")
    List<Article> selectAll();

    @Select("SELECT COUNT(*) FROM article")
    int selectAllCount();

    @ResultMap("articleResult")
    @Select("SELECT * FROM article WHERE member_id=#{memberId}")
    List<Article> selectByMemberId(@Param("memberId") Long memberId);

    @Insert("""
        INSERT INTO article(title, description, created, updated, member_id)
            VALUES(#{article.title}, #{article.description}, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, #{article.memberId})
    """)
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(@Param("article") Article article);

    @Update("""
        UPDATE article
            SET title=#{title}, description=#{description}, updated=CURRENT_TIMESTAMP
            WHERE id=#{id}
    """)
    int update(@Param("id") Long id, @Param("title") String title, @Param("description") String description);

    @Delete("DELETE article WHERE id=#{id}")
    int deleteById(@Param("id") Long id);
}

