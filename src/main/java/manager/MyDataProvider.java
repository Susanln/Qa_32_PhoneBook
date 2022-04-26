package manager;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {
    @DataProvider
    public Iterator<Object[]> validLoginData()
    {
        List<Object[]> list= new ArrayList<>();
        list.add(new Object[]{"noa@gmail.com","Nnoa12345$"});
        list.add(new Object[]{"noa@gmail.com","Nnoa12345$"});
        list.add(new Object[]{"noa@gmail.com","Nnoa12345$"});
        list.add(new Object[]{"noa@gmail.com","Nnoa12345$"});
        return list.iterator();
    }
}
