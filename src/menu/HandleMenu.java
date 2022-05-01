package menu;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HandleMenu {
    public void handleMainMenu() throws IOException {
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
                        break;
                    case 5:
                        Menu.nearbyWeatherDisplay();
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
        Menu.weatherMenuForTheNext9Days();
        do {
            try {
                switch (choose){
                    case 1:
                        System.out.println("???");
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
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
}
