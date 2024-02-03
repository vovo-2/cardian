import { create } from "zustand";

interface CategoryConsumeDetail {
  categoryCode: string;
  entireConsume: number;
}

interface MonthlyCategoryConsume {
  month: number;
  totalConsume: number;
  CategoryConsumeDetailList: CategoryConsumeDetail[];
}

interface EntireCardTransaction {
  memberId: number;
  monthlyCaetegoryConsumeList: MonthlyCategoryConsume[];

  setMemberId: (memberId: number) => void;
  setMonthlyCaetegoryConsumeList: (item: MonthlyCategoryConsume[]) => void;
}

const MonthlyCategoryResultStore = create<EntireCardTransaction>((set) => ({
  memberId: 1,
  monthlyCaetegoryConsumeList: [],

  setMemberId: (memberId: number) => set({ memberId }),
  setMonthlyCaetegoryConsumeList: (
    monthlyCaetegoryConsumeList: MonthlyCategoryConsume[]
  ) => set({ monthlyCaetegoryConsumeList }),
}));

export default MonthlyCategoryResultStore;
