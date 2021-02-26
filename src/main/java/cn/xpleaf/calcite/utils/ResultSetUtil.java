package cn.xpleaf.calcite.utils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultSetUtil {

    public static String resultString(ResultSet resultSet) throws SQLException {
        return resultString(resultSet, false);
    }

    public static String resultString(ResultSet resultSet, boolean printHeader) throws SQLException {
        List<List<Object>> resultList = resultList(resultSet, printHeader);
        return resultString(resultList);
    }

    public static List<List<Object>> resultList(ResultSet resultSet) throws SQLException {
        return resultList(resultSet, false);
    }

    public static String resultString(List<List<Object>> resultList) throws SQLException {
        StringBuilder builder = new StringBuilder();
        resultList.forEach(row -> {
            String rowStr = row.stream()
                    .map(columnValue -> columnValue + ", ")
                    .collect(Collectors.joining());
            rowStr = rowStr.substring(0, rowStr.lastIndexOf(", ")) + "\n";
            builder.append(rowStr);
        });
        return builder.toString();
    }

    public static List<List<Object>> resultList(ResultSet resultSet, boolean printHeader) throws SQLException {
        ArrayList<List<Object>> results = new ArrayList<>();
        final ResultSetMetaData metaData = resultSet.getMetaData();
        final int columnCount = metaData.getColumnCount();
        if (printHeader) {
            ArrayList<Object> header = new ArrayList<>();
            for (int i = 1; i <= columnCount; i++) {
                header.add(metaData.getColumnName(i));
            }
            results.add(header);
        }
        while (resultSet.next()) {
            ArrayList<Object> row = new ArrayList<>();
            for (int i = 1; i <= columnCount; i++) {
                row.add(resultSet.getObject(i));
            }
            results.add(row);
        }
        return results;
    }

}