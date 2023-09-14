package sample;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 *
 *
 * Implement in single class.
 */
public class DateSorter {
    /**
     * The implementation of this method should sort dates.
     * The output should be in the following order:
     * Dates with an 'r' in the month,
     * sorted ascending (first to last),
     * then dates without an 'r' in the month,
     * sorted descending (last to first).
     * For example, October dates would come before May dates,
     * because October has an 'r' in it.
     * thus: (2005-07-01, 2005-01-02, 2005-01-01, 2005-05-03)
     * would sort to
     * (2005-01-01, 2005-01-02, 2005-07-01, 2005-05-03)
     *
     * @param unsortedDates - an unsorted list of dates
     * @return the collection of dates now sorted as per the spec
     */
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        List<LocalDate> storageOfMonthsWithR = new ArrayList<>();
        List<LocalDate> storageOfMonthsWithoutR = new ArrayList<>();
        for (LocalDate date : unsortedDates) {
            if (date.getMonthValue() >= 5 && date.getMonthValue() <= 8) {
                storageOfMonthsWithoutR.add(date);
            } else {
                storageOfMonthsWithR.add(date);
            }
        }
        //sort dates with the character r in ascending order
        storageOfMonthsWithR.sort(LocalDate::compareTo);
        //sort dates with the character r in descending order
        storageOfMonthsWithoutR.sort((o2, o1) -> {
            int cmp = (o1.getYear() - o2.getYear());
            if (cmp == 0) {
                cmp = (o1.getMonthValue() - o2.getMonthValue());
                if (cmp == 0) {
                    cmp = (o1.getDayOfMonth() - o2.getDayOfMonth());
                }
            }
            return cmp;
        });
        storageOfMonthsWithR.addAll(storageOfMonthsWithoutR);
        return storageOfMonthsWithR;
    }
}
