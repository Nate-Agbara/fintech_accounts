package com.fintech.accounts;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author: Nathan
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class DataStoreSystemsHealthTest {

    @Autowired
    DataSource dataSource;

    @Test
    public void dbPrimaryIsOk(){
        try {
            DatabaseMetaData metaData = dataSource.getConnection().getMetaData();
            String catalogName = dataSource.getConnection().getCatalog();

            //assertThat("",metaData, is(notNullValue()));
            assertNotNull(metaData.nullPlusNonNullIsNull());
            assertEquals("fintech", catalogName);

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
