public class UsageTracker {
    private static final int[] TIER_LIMITS = {10, 50, 200, 500};
    private static final PlanType[] TIERS = {PlanType.BASIC, PlanType.SILVER, PlanType.GOLD, PlanType.PREMIUM};

    public static void addUsage(UserSubscription sub, int units) {
        sub.setUsageUnits(sub.getUsageUnits() + units);

        System.out.println(units + "Units -> Total: " + sub.getUsageUnits());

        PlanType recommended = getRecommendedTier(sub.getUsageUnits());
        if (recommended.ordinal() > sub.getPlanType().ordinal()) {
            System.out.println("RECOMMEND : Upgrade to " + recommended.name() + (" Limit :" + TIER_LIMITS[recommended.ordinal()] + " Units)"));
        }
    }

    public static PlanType getRecommendedTier(int usage) {
        if (usage <= 10) return PlanType.BASIC;
        if (usage <= 50) return PlanType.SILVER;
        if (usage <= 200) return PlanType.GOLD;
        return PlanType.PREMIUM;  // 500+ = PREMIUM
    }

    public static void generateUsageReport(UserSubscription[] subs, int count) {
        System.out.println("USAGE ANALYTICS");

        for (int i = 0; i < count; i++) {
            UserSubscription sub = subs[i];
            String status = sub.getUsageUnits() > TIER_LIMITS[sub.getPlanType().ordinal()] ? "OVERAGE!" : "OK";
            System.out.printf("ID:%d %-10s %4d units | %s | %s%n",
                    sub.getUser().getId(), sub.getUser().getName(), sub.getUsageUnits(), sub.getPlanType(), status);

        }
    }

    //get limit for plan
    private static int getTierLimit(PlanType plan) {
        switch (plan) {
            case BASIC:
                return 10;
            case SILVER:
                return 50;
            case GOLD:
                return 200;
            case PREMIUM:
                return 500;
            default:
                return 10;
        }
    }
}