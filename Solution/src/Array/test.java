package Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class test {

  private void populateAdjustmentData(List<testObject> externalFeeDetailsList) {


    // Optional.ofNullable(externalFeeDetailsList)
    // .ifPresent(list -> list.stream().filter(obj -> FeeConstants.FEE_ADJUSTMENT_TYPE_EXTERNAL
    // .equalsIgnoreCase(obj.getReason().toString())));


    Optional.ofNullable(externalFeeDetailsList)
        .ifPresent(list -> list.stream().filter(obj -> "xx".equalsIgnoreCase(obj.getReason())).findFirst().ifPresent(t -> {
          if (t.getReason() != null && t.getPercentFee() <= 0.0 && t.getFixedFee() == null) {
          }
//          if (t.getFeeApplicationMethod() != null && t.getFeeApplicationMethod().toString()
//              .equalsIgnoreCase(FeeApplicationMethod.Method.ADD.toString())) {
//            FFXAdjustmentCurrency ffxAdjustmentCurrency = new FFXAdjustmentCurrency();
//            ffxAdjustmentCurrency.setCurrencyCode(t.getFixedFee().getCurrencyCode());
//            ffxAdjustmentCurrency.setFixedAdjustment(
//                Double.valueOf(t.getFixedFee().toJavaCurrency().getAmount()));
//            adjCurrencies.add(ffxAdjustmentCurrency);
//            adjustment.setPercentAdjustment(t.getPercentFee() / 100);
//          }
          return;
        }));


//    Optional.ofNullable(externalFeeDetailsList)
//        .ifPresent(list -> list.stream().filter(obj -> FeeConstants.FEE_REASON_TYPE_INTERCHANGE
//            .equalsIgnoreCase(obj.getReason().toString())).findFirst().ifPresent(t -> {
//          FFXAdjustmentCurrency ffxAdjustmentCurrency = new FFXAdjustmentCurrency();
//          ffxAdjustmentCurrency.setCurrencyCode(t.getFixedFee().getCurrencyCode());
//          ffxAdjustmentCurrency.setFixedAdjustment(Double.valueOf(t.getFixedFee().getValue()));
//          adjCurrencies.add(ffxAdjustmentCurrency);
//          adjustment.setPercentAdjustment(t.getPercentFee() / 100);
//        }));
  }

  public static void main(String[] args){
    test test = new test();
    testObject testObject = new testObject();
    List<testObject> list = new ArrayList<>();
    test.populateAdjustmentData(list);
  }

}
