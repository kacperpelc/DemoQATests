package com.pel.bookStoreApplication;

import com.pel.foundation.Base;
import com.pel.pages.bookStoreApplication.bookStoreApi.AccountRequest;
import com.pel.pages.bookStoreApplication.bookStoreApi.BookStoreRequest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class BookStoreApplicationTest extends Base {
    private final AccountRequest accountRequest = new AccountRequest();
    private final BookStoreRequest bookStoreRequest = new BookStoreRequest();

    @Tag("211")
    @DisplayName("Book store API test")
    @Disabled
    @Test
    public void bookStoreApplicationTest() {

    }
}
