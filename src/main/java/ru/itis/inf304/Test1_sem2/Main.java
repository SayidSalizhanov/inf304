package ru.itis.inf304.Test1_sem2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //считывание файла
        Scanner s = new Scanner(new File("schedule.txt"));
        List<String> list = new ArrayList<>();
        while (s.hasNext()){
            list.add(s.nextLine());
        }
        s.close();

        // заполним массив времени
        List<String> times = new ArrayList<>();
        for (String i : list) {
            if (i.charAt(0) <= '9' && i.charAt(0) >= '0') times.add(i);
        }

        System.out.println(times + "\n");

        //создадим массив каналов
        Set<String> channels = new HashSet<>();
        for (String i : list) {
            if (i.charAt(0) == '#') channels.add(i);
        }

        // map (время, список программ)
        Map<String, List<Program>> channelsAndPrograms = new LinkedHashMap<>();

        String channel = null;
        for (String i : times) {
            List<Program> programs = new ArrayList<>();
            for (int j = 0; j < list.size(); j++) {
                if (channels.contains(list.get(j))) channel = list.get(j);
                if (list.get(j).equals(i)) programs.add(new Program(channel, new BroadcastsTime(i), list.get(j+1)));
            }

            List<Program> programs1 = new ArrayList<>(programs);
            channelsAndPrograms.put(i, programs1);
            programs.clear();
        }

        System.out.println(channelsAndPrograms + "\n");

        List<Program> programsAll = new ArrayList<>();
        channel = null;
        for (int i = 0; i < list.size(); i++) {
            if (channels.contains(list.get(i))) {
                channel = list.get(i);
                continue;
            }
            if (times.contains(list.get(i))) {
                programsAll.add(new Program(channel, new BroadcastsTime(list.get(i)), list.get(i+1)));
                i++;
            }
        }

        System.out.println(programsAll + "\n");

        System.out.println(sortWithName(programsAll) + "\n");

        System.out.println(programsNow("04:45", programsAll) + "\n");

        System.out.println(programsOnChannelNow("04:45", "#Первый", programsAll) + "\n");

        System.out.println(programsOnChannelInTimePart("04:45", "06:00", "#Первый", programsAll) + "\n");
    }

    // сортировка по названии
    public static List<Program> sortWithName(List<Program> programsAll) {
        List<Program> sortedPrograms = new ArrayList<>(programsAll);

        Collections.sort(sortedPrograms, new Comparator<Program>() {
            @Override
            public int compare(Program o1, Program o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        return sortedPrograms;
    }

    // программы сейчас
    public static List<Program> programsNow(String time, List<Program> programsAll) {
        List<Program> programs = new ArrayList<>();

        BroadcastsTime timeInt = new BroadcastsTime(time);

        for (Program k : programsAll) {
            if (Objects.equals(k.getTime().getAllMinutes(), timeInt.getAllMinutes())) {
                programs.add(k);
            }
        }

        return programs;
    }

    // программы сейчас на канале
    public static List<Program> programsOnChannelNow(String time, String channel, List<Program> programsAll) {
        List<Program> programsOnChannelNow = new ArrayList<>();

        BroadcastsTime timeInt = new BroadcastsTime(time);

        for (Program k : programsAll) {
            if (Objects.equals(k.getTime().getAllMinutes(), timeInt.getAllMinutes()) && k.getChannel().equals(channel)) {
                programsOnChannelNow.add(k);
            }
        }

        return programsOnChannelNow;
    }

    // все программы определённого канала, которые будут идти в некотором промежутке времени
    public static List<Program> programsOnChannelInTimePart(String time1, String time2, String channel, List<Program> programsAll) {
        List<Program> programs = new ArrayList<>();

        BroadcastsTime timeInt1 = new BroadcastsTime(time1);
        BroadcastsTime timeInt2 = new BroadcastsTime(time2);

        for (Program k : programsAll) {
            if (k.getChannel().equals(channel) && k.getTime().between(timeInt1, timeInt2)) {
                programs.add(k);
            }
        }

        return programs;
    }
}
