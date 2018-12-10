package com.alexdb.dtpatterns.chainOfInvocations;

import com.alexdb.dtpatterns.common.Page;

public interface COILoadableComponent extends Page {
    Page load();
    Page isLoaded();
}


