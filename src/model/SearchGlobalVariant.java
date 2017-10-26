package model;

import controller.SearchController;
import view.SearchView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchGlobalVariant implements SearchRequest {//поиск удовлетворяющих всем вариантов проведения саммита
    SearchController searchController = new SearchController();
    SearchView view = new SearchView();

    public void search() throws SQLException {
        //запрос на нахождение страны и месяца, которые есть у каждого из лидеров
        ResultSet res = searchController.findFinalResult();
        while (res.next()) {
            if (resultMatrix(res.getString("country"), res.getInt("month")) != null) {
                view.showSearchResult(res.getString("country") + ", ",
                        numberInMonth(res.getInt("month")),
                        resultMatrix(res.getString("country"), res.getInt("month")));
            }
        }
    }

    private StringBuffer resultMatrix(String country, int month) throws SQLException {//побитовое складывание всех массивов, найденных в БД по конкретному предложению
        ArrayList<int[]> allMatrixOfQuery = new ArrayList<>();
        StringBuffer dates = new StringBuffer();
        int[] result = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};


        ResultSet rs = searchController.selectIntervalDate(country, month);

        while (rs.next()) {
            allMatrixOfQuery.add(parsingStringToMatrix(rs.getString("intervalDate")));
        }

        for (int i = 0; i < allMatrixOfQuery.size(); i++) {
            for (int j = 0; j < 31; j++) {
                result[j] = result[j] & allMatrixOfQuery.get(i)[j];
            }
        }

        for (int i = 0; i < 31; i++) {
            if (result[i] == 1) dates.append(i + 1 + ", ");
        }

        if (dates.length() == 0) return null;
        else return dates.deleteCharAt(dates.length() - 2);
    }

    private int[] parsingStringToMatrix(String intervalDate) {//преобразование интервалов дат, взятых из БД, в массив
        int[] startMatrix = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        String[] intervals = intervalDate.split(",|-");

        for (int i = 0; i < intervals.length; i += 2) {
            int start = Integer.parseInt(intervals[i]);
            int finish = Integer.parseInt(intervals[i + 1]);

            for (int j = start; j <= finish; j++) {
                startMatrix[j - 1] = 1;
            }
        }

        return startMatrix;
    }

    private String numberInMonth(int i) {//перевод из числового представления месяца в строковый
        String[] s = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
        return s[i - 1];
    }
}
