package ru.job4j.departments;

import java.util.*;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 22.05.2019
 */

/**
 * Класс сортирует департаменты по наименованиям подразделений.
 */
public class Departments {
    public static final class Org implements Comparable<Org> {
        private final List<String> deps = new ArrayList<>();

        public Org(List<String> deps) {
            for (String str: deps) {
                this.deps.add(str);
            }
        }

        /**
         * Метод сравнивает строки подразделений.
         * @return результат сравнения.
         */
		@Override
		public int compareTo(Org o) {
			int result = 0;
			int size = this.deps.size() < o.deps.size() ? this.deps.size() : o.deps.size();
			for (int i = 0; i < size; i++) {
				if (this.deps.get(i).equals(o.deps.get(i))) {
					continue;
				}
				result = this.deps.get(i).compareTo(o.deps.get(i));
				break;
			}
			if (result == 0 && this.deps.size() != o.deps.size()) {
				result = this.deps.size() < o.deps.size() ? -1 : 1;
			}
			return result;
		}		
		
        @Override
        public String toString() {
			StringBuffer result = new StringBuffer();
			for (String str: deps) {
				result.append(str);
				result.append("/");
			}
			return result.toString();
        }

        @Override
        public boolean equals(Object o) {
            Org org = (Org) o;
            if (this == o) {
				return true;
			}	
            if (o == null || getClass() != o.getClass() || this.deps.size() != org.deps.size()) {
				return false;
			}	
            for (int i = 0; i < this.deps.size(); i++) {
                if (!this.deps.get(i).equals(org.deps.get(i))) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public int hashCode() {
            return deps != null ? deps.hashCode() : 0;
        }
    }

    /**
     * Метод конвертирует список наименований подразделений в список объектов.
     * @param deps - список наименований подразделений
     * @return - список подразделений в виде списка объектов
     */
    public List<Org> convert(List<String> deps) {
		List<Org> orgs = new ArrayList<>();
        List<String> temp = new ArrayList<>();
		for (String dep: deps) {
            Departments.Org org = new Departments.Org(temp);
			for (String substr : dep.split("/")) {
                org.deps.add(substr);
			}
            orgs.add(new Departments.Org(org.deps));
		}
		return recoverOrgs(orgs);
	}

    /**
     * Метод добавляет в список подразделений недостающие строки с кодом данного подразделения.
     * @param orgs - первичный список подразделений
     * @return - дополненый спискок подразделений
     */
    public List<Org> recoverOrgs(List<Org> orgs) {
		List<Org> result = new ArrayList<>(orgs);
        List<String> temp = new ArrayList<>();
        Set<Org> orgSet = new TreeSet<>();
        for (Org name: orgs) {
            Departments.Org org = new Departments.Org(temp);
            for (String str: name.deps) {
                org.deps.add(str);
                if (!result.contains(org)) {
                    result.add(new Departments.Org(org.deps));
                }
            }
        }
        orgSet.addAll(result);
        List<Org> resultSort = new ArrayList<>(orgSet);
        return resultSort;
    }

    /**
     * Метод сортирует список подразделений по возрастанию.
     * @param orgs - исходный список
     * @return - результат сортировки
     */	
    public List<Org> sortAsc(List<Org> orgs) {
		orgs.sort(new Comparator<Org>() {
		    @Override
		    public int compare(Org o1, Org o2) {
		        return o1.compareTo(o2);
		    }
		});
        return orgs;		
    }

    /**
     * Метод сортирует список подразделений по убыванию.
     * @param orgs - исходный список
     * @return - результат сортировки
     */	
    public List<Org> sortDesc(List<Org> orgs) {
		orgs.sort(new Comparator<Org>() {
		    @Override
		    public int compare(Org o1, Org o2) {
                int result = 0;
                int size = o1.deps.size() < o2.deps.size() ? o1.deps.size() : o2.deps.size();
                for (int i = 0; i < size; i++) {
                    if (o1.deps.get(i).equals(o2.deps.get(i))) {
                        continue;
                    }
                    result = o1.deps.get(i).compareTo(o2.deps.get(i)) == -1 ? 1 : -1;
                    break;
                }
                if (result == 0 && o1.deps.size() != o2.deps.size()) {
                    result = o1.deps.size() < o2.deps.size() ? -1 : 1;
                }
                return result;
            }
		});
        return orgs;		
    }
}
