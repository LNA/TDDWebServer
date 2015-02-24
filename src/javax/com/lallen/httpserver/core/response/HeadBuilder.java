package javax.com.lallen.httpserver.core.response;
import java.io.IOException;

public class HeadBuilder implements iHeader {
    public static final String ALLOW = "Allow: GET,HEAD,POST,OPTIONS,PUT\r\n";
    public static final String NEW_LINE = "\r\n";
    public static final String LOCATION = "Location: http://localhost:";
    public static final String END = "/";

    @Override
    public byte[] buildResponseHead(int port, String status) throws IOException {
/*        Car car = new CarBuilder()
                .setYear(2012)
                .setMake("Honda")
                .build();*/
        StringBuilder stringBuilder = new StringBuilder();
        appendLines(stringBuilder, port, status);
        String lines = stringBuilder.toString();
        System.out.println("head lines" + lines);
        return lines.getBytes();
    }

    private void appendLines(StringBuilder stringBuilder, int port, String status) {
        stringBuilder.append(status);
        stringBuilder.append(ALLOW);
        stringBuilder.append(LOCATION + port + END + NEW_LINE);
        stringBuilder.append(NEW_LINE);
    }
/*
    private class CarBuilder {
        private int year;
        private String make;

        public CarBuilder setYear(int year) {
            this.year = year;
            return this;
        }

        public CarBuilder setMake(String make) {
            this.make = make;
            return this;
        }

        public Car build() {
            return new Car(year, make);
        }
    }

    private class Car {
        private final String make;
        private final int year;

        public Car(int year, String make) {
            this.year = year;
            this.make = make;
        }
    }*/
}
