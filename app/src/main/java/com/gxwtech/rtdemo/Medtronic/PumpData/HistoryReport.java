package com.gxwtech.rtdemo.Medtronic.PumpData;

import com.gxwtech.rtdemo.Medtronic.PumpData.records.BolusWizard;

import java.util.ArrayList;

/**
 * Created by geoff on 6/5/15.
 *
 * This class is inteded to gather what information we've gleaned from the pump history
 * into one place, make it easier to move around.
 *
 */
public class HistoryReport {
    public ArrayList<BolusWizard> mBolusWizardEvents;
    public HistoryReport() {
        mBolusWizardEvents = new ArrayList<>();
    }
    public void addBolusWizardEvent(BolusWizard event) {
        mBolusWizardEvents.add(event);
    }
}
