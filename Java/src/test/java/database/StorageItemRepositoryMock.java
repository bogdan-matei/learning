package database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.StorageItemRepository;

import static org.mockito.Mockito.when;

public class StorageItemRepositoryMock {

    @Mock
    private StorageItemRepository repository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenSavingNullObjectWithValidConnectionShouldReturnFalse() {
        when(repository.create(null, DbConnection.getConnection())).thenReturn(false);

        boolean result = repository.create(null, DbConnection.getConnection());

        Assert.assertFalse(result);
    }

}
