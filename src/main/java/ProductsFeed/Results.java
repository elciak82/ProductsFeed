package ProductsFeed;

import java.util.ArrayList;
import java.util.List;

public class Results {

    List< Result > results;

    public Results(List results) {
        this.results = results;
    }

    public List< Result > get() {
        return this.results;
    }

    public Result getResult(int i) {
        return this.results.get(i);
    }

    public int size() {
        return this.results.size();
    }

    @Override
    public String toString() {
        return this.results.toString();
    }

    public Results filterByOnlineOnly() {
        List< Result > list = new ArrayList();

        for (Result r : this.results)
            if (r.onlineOnly() == true)
                list.add(r);

        return new Results(list);
    }

    public Results filterByOwner(String name) {
        List< Result > list = new ArrayList();

        for (Result r : this.results)
            if (r.owner().equals(name))
                list.add(r);

        return new Results(list);
    }

    public Results filterByName(String name) {
        List< Result > list = new ArrayList();

        for (Result r : this.results)
            if (r.name().equals(name))
                list.add(r);

        return new Results(list);
    }

    public Results filterByPrice(int price) {
        List< Result > list = new ArrayList();

        for (Result r : this.results)
            if (r.price() == price)
                list.add(r);

        return new Results(list);
    }

//    public Results filterBy(Predicate predicate) {
//
//        List< Result > list = this.results.stream()
//                .filter(predicate)
//                .collect(Collectors.toList());
//
//        return new Results(list);
    }

