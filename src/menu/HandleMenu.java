package menu;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HandleMenu {
    public void handleMainMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int choose = -1;
        do {
            try {
                Menu.GeneralWeatherMenu();
                choose = scanner.nextInt();
                switch (choose) {
                    case 1:

                        break;
                    case 2:
                        Menu.GeneralWeatherMenu();
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Vui lòng nhập đúng lựa chọn trong menu !");
                }

            } catch (InputMismatchException e) {
                System.err.println("Vui lòng nhập đúng định dạng !");
                scanner.nextLine();
                choose = -1;
            }
        } while (choose != 0);

    }



    // Menu Hà Nội
    public void handleHaNoiMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int choose = -1;
        Menu.nearbyWeatherDisplay();
        do {
            try {
                choose = scanner.nextInt();
                switch (choose) {
                    case 1:
                        handleCurrentWeatherCase();
                        break;
                    case 2:
                        handleCaseForecastToday();
                        break;
                    case 3:
                        handleCaseForecastTonight();
                        break;
                    case 4:
                        handleSeeTheWeatherForTheNext9days();
                        break;
                    case 5:
                        Menu.nearbyWeatherDisplay();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Vui lòng nhập đúng lựa chọn trong menu !");
                }

            } catch (InputMismatchException e) {
                System.err.println("Vui lòng nhập đúng định dạng !");
                scanner.nextLine();
                choose = -1;
            }
        } while (choose != 0);
    }

    //Xử lý thời gian cập nhật của các case dự báo
    public String handlUpdateTime(int index) {
        String timeUpdate = "";
        try {
            String[] listTimeUpdate = UsingURL.getUpdateTime();
            timeUpdate += listTimeUpdate[index];
        } catch (IOException e) {
            e.printStackTrace();
        }
        return timeUpdate;
    }

    //Xử lý các thông tin dự báo
    public String processingForecastingInformation(int index) {
        String forecastInformation = "";
        try {
            String[] listTimeUpdate = UsingURL.getForecastInformation();
            forecastInformation += listTimeUpdate[index];
        } catch (IOException e) {
            e.printStackTrace();
        }
        return forecastInformation;
    }

    //Xử lý thời tiết hiện tại
    public void handleCurrentWeatherCase() {
        System.out.println("THỜI TIẾT HIỆN TẠI");
        String timeUpdateCwc = "Thời gian : " + handlUpdateTime(0);
        String forecastInformation = "\nNhiệt độ  : " + processingForecastingInformation(0)
                + "\nThời tiết : " + processingForecastingInformation(1)
                + "\nĐộ ẩm     : " + processingForecastingInformation(2)
                + "\nHướng gió : " + processingForecastingInformation(3);
        System.out.println(timeUpdateCwc + forecastInformation);
    }

    //Xử lý thời tiết ngày hôm nay
    public void handleCaseForecastToday() {
        System.out.println("DỰ BÁO THỜI TIẾT NGÀY HÔM NAY");
        String timeUpdateCft = "Thời gian " + handlUpdateTime(1);
        String forecastInformation = "\nNhiệt độ  : " + processingForecastingInformation(4)
                + "\nĐộ ẩm     : " + processingForecastingInformation(5)
                + "\nHướng gió : " + processingForecastingInformation(6).replaceAll
                ("(<)\\w{3} \\w{3}=(.*?)(>) ", "");
        System.out.println(timeUpdateCft + forecastInformation);
    }

    //Xử lý thời tiết đêm hôm nay
    public void handleCaseForecastTonight() {
        System.out.println("DỰ BÁO THỜI TIẾT ĐÊM HÔM NAY");
        String timeUpdateCfTo = "Thời gian " + handlUpdateTime(2);
        String forecastInformation = "\nNhiệt độ  : " + processingForecastingInformation(7)
                + "\nĐộ ẩm     : " + processingForecastingInformation(8)
                + "\nHướng gió : " + processingForecastingInformation(9).replaceAll
                ("(<)\\w{3} \\w{3}=(.*?)(>) ", "");
        System.out.println(timeUpdateCfTo + forecastInformation);
    }

    // Xử lý xem thời tiết 9 ngày tới ở case 4
    public void handleSeeTheWeatherForTheNext9days() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int choose = -1;
        String[] windSpeed = UsingURL.getTheDayInformationFromURL();
        Menu.weatherMenuForTheNext9Days();
        do {
            try {
                choose = scanner.nextInt();
                switch (choose) {
                    case 1:
                        System.out.println(Menu.dateAfterCutting(0));
                        System.out.println(getTheDayInformation(0,1,3));
                        System.out.println("Tốc độ gió : " + windSpeed[4]);
                        break;
                    case 2:
                        System.out.println(Menu.dateAfterCutting(1));
                        System.out.println(getTheDayInformation(5,6,8));
                        System.out.println("Tốc độ gió : " + windSpeed[9]);
                        break;
                    case 3:
                        System.out.println(Menu.dateAfterCutting(2));
                        System.out.println(getTheDayInformation(10,11,13));
                        break;
                    case 4:
                        System.out.println(Menu.dateAfterCutting(3));
                        System.out.println(getTheDayInformation(15,16,18));
                        break;
                    case 5:
                        System.out.println(Menu.dateAfterCutting(4));
                        System.out.println(getTheDayInformation(20,21,23));
                        break;
                    case 6:
                        System.out.println(Menu.dateAfterCutting(5));
                        System.out.println(getTheDayInformation(25,26,28));
                        break;
                    case 7:
                        System.out.println(Menu.dateAfterCutting(6));
                        System.out.println(getTheDayInformation(30,31,33));
                        break;
                    case 8:
                        System.out.println(Menu.dateAfterCutting(7));
                        System.out.println(getTheDayInformation(35,36,38));
                        break;
                    case 9:
                        System.out.println(Menu.dateAfterCutting(8));
                        System.out.println(getTheDayInformation(40,41,43));
                        break;
                    case 10:
                        Menu.nearbyWeatherDisplay();
                        break;
                    default:
                        System.out.println("Vui lòng nhập lựa chọn trong menu !");
                }
            } catch (InputMismatchException e) {
                System.err.println("Vui lòng nhập đúng định dạng !");
                scanner.nextLine();
                choose = -1;
            }
        } while (choose != 10);
    }

    // Thông tin các ngày
    public String getTheDayInformation(int largeTemp, int smallTemp , int humidity) throws IOException {
        String information = "";
        String[] dayInformationFromURL = UsingURL.getTheDayInformationFromURL();
        information = "Nhiệt độ cao nhất  : " + dayInformationFromURL[largeTemp] + "\n" +
                "Nhiệt độ thấp nhất : " + dayInformationFromURL[smallTemp] + "\n" +
                "Độ ấm              : " + dayInformationFromURL[humidity].replaceAll("&\\w{4};" , "");
        return information;
    }
}
