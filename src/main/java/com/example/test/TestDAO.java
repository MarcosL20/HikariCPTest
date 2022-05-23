package com.example.test;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.stereotype.Repository;

@Repository
public class TestDAO {
   
    @Value("${spring.jpa.properties.hibernate.jdbc.batch_size:10000}") // default = 1000
    private Integer batchSize;
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    TestRepository testRepository;
    
    public void saveAllDAO(List<Test> entities) {
        
        jdbcTemplate.batchUpdate(
                "INSERT INTO test "
                + "(id, value)"
                + "VALUES (?,?)",
                entities,
                batchSize,
                new ParameterizedPreparedStatementSetter<Test>() {
                    @Override
                    public void setValues(PreparedStatement ps, Test testEntity) throws SQLException {
                        ps.setObject(1, testEntity.getId(), java.sql.Types.VARCHAR);
                        ps.setObject(2, testEntity.getValue(), java.sql.Types.VARCHAR);
                    }
                });
        
    }
    
}
