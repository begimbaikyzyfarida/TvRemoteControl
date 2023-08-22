public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean NTV = false; // Переменная для хранения состояния телевизора (вкл/выкл)
        int currentChannel = 0; // Переменная для хранения текущего канала

        String[] channels = {
                "Канал Маданият ", "Канал Элтр", "Канал Мир", "Канал Баластан",
                "Канал Спорт", "Канал Илим-Билим", "Канал КИНО ТВ", "Канал Музыка"
        };

        String[] channelArt = {
                        "+--------------------------+\n" +
                        "| название канала МАДАНИЯТ |\n" +
                        "|                          |\n" +
                        "|                          |\n" +
                        "| номер канала 1           |\n" +
                        "+--------------------------+\n" ,
                        "+--------------------------+\n" +
                        "| название канала     Элтр |\n" +
                        "|                          |\n" +
                        "|                          |\n" +
                        "| номер канала 2           |\n" +
                        "+--------------------------+\n" ,
                        "+--------------------------+\n" +
                        "| название канала     МИР  |\n" +
                        "|                          |\n" +
                        "|                          |\n" +
                        "| номер канала 3           |\n" +
                        "+--------------------------+\n" ,
                        "+--------------------------+\n" +
                        "| название канала Баластан |\n" +
                        "|                          |\n" +
                        "|                          |\n" +
                        "| номер канала 4           |\n" +
                        "+--------------------------+\n" ,
                        "+--------------------------+\n" +
                        "| название канала    Спорт |\n" +
                        "|                          |\n" +
                        "|                          |\n" +
                        "| номер канала 5           |\n" +
                        "+--------------------------+\n" ,
                        "+---------------------------+\n" +
                        "|название канала Илим-Билим |\n" +
                        "|                           |\n" +
                        "|                           |\n" +
                        "| номер канала 6            |\n" +
                        "+---------------------------+\n" ,
                        "+--------------------------+\n" +
                        "| название канала  КИНО ТВ |\n" +
                        "|                          |\n" +
                        "|                          |\n" +
                        "| номер канала 7           |\n" +
                        "+--------------------------+\n" ,
                        "+--------------------------+\n" +
                        "| название канала   МУЗЫКА |\n" +
                        "|                          |\n" +
                        "|                          |\n" +
                        "| номер канала 8           |\n" +
                        "+--------------------------+\n" };


        while (!NTV) {
            System.out.println("Пульт не будет работать до тех пор, пока вы не нажмете 'on'");
            pult();

            String onCommand = scanner.nextLine();
            if (onCommand.equals("on")) {
                NTV = true;
            }
        }welcome();
        pult();

        String command;
        do {
            command = scanner.nextLine();

            switch (command) {
                case "menu":
                    displayChannelsMenu(channels);
                    pult();
                    break;

                case "next":
                    currentChannel = getNextChannel(currentChannel, channels.length);
                    displayChannelArt(currentChannel, channelArt);
                    pult();
                    break;

                case "back":
                    currentChannel = getPreviousChannel(currentChannel, channels.length);
                    displayChannelArt(currentChannel, channelArt);
                    pult();
                    break;

                case "off":
                    System.out.println("Телевизор выключен.");
                    pult();
                    return;

                default:
                    try {
                        currentChannel = Integer.parseInt(command);
                        if (currentChannel < 1 || currentChannel > channels.length) {
                            System.out.println("Неподдерживаемый канал");
                            currentChannel = 0;
                        } else {
                            displayChannelArt(currentChannel, channelArt);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Неправильная команда");
                    }
                    break;
            }
        } while (true);
    }

    private static void displayChannelsMenu(String[] channels) {
        System.out.println("   Меню каналов   ");
        for (int i = 0; i < channels.length; i++) {
            System.out.println((i + 1) + ". " + channels[i]);
        }
        System.out.println("--------------------");
    }

    private static void displayChannelArt(int channel, String[] channelArt) {
        System.out.println(channelArt[channel - 1]);
    }

    private static int getNextChannel(int currentChannel, int totalChannels) {
        return currentChannel % totalChannels + 1;
    }

    private static int getPreviousChannel(int currentChannel, int totalChannels) {
        return ((currentChannel - 2 + totalChannels) % totalChannels) + 1;
    }
    public static void pult() {
        String menuText =
                "        TV пульт\n" +
                "+---------------------+\n" +
                "|  OFF            ON  |\n" +
                "|        (menu)       |\n"+
                "|  <-back     next -> |\n" +
                "|     1          2    |\n" +
                "|                     |\n"+
                "|     3          4    |\n" +
                "|                     |\n"+
                "|     5          6    |\n" +
                "|                     |\n"+
                "|     7          8    |\n" +
                "|       SAMSUNG       |\n"+
                "|    MADE BY FARIDA   |\n"+
                "+---------------------+";

        System.out.println(menuText);
        System.out.println("Введите номер канала для просмотра.");
        System.out.println("Введите 'menu' для показа меню каналов.");
        System.out.println("Введите 'off' для выключения телевизора.");
        System.out.println("Введите 'next' для переключения на следующий канал.");
        System.out.println("Введите 'back' для переключения на предыдущий канал.");
        System.out.print("Строка для ввода :");
    }private static void welcome(){
        System.out.println("+--------------------------------------+");
        System.out.println("|          ДОБРО ПОЖАЛОВАТЬ            |");
        System.out.println("|                                      |");
        System.out.println("|         SAMSUNG SMART  TV            |");
        System.out.println("|                                      |");
        System.out.println("+--------------------------------------+");
    }
}
