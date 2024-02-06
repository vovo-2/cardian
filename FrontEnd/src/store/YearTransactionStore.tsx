import { create } from "zustand";

interface YearTransaction {
  memberId: number;
  yearConsumeAmount: number;
  monthlyConsumeAmount: number[];

  setMemberId: (memberId: number) => void;
  setYearConsumeAmount: (yearConsumeAmount: number) => void;
  setMonthlyConsumeAmount: (monthlyConsumeAmount: number[]) => void;
}

const YearTransactionStore = create<YearTransaction>((set) => ({
  memberId: 0,
  yearConsumeAmount: 0,
  monthlyConsumeAmount: [],
  setMemberId: (memberId: number) => set({ memberId }),
  setYearConsumeAmount: (yearConsumeAmount: number) =>
    set({ yearConsumeAmount }),
  setMonthlyConsumeAmount: (monthlyConsumeAmount: number[]) =>
    set({ monthlyConsumeAmount }),
}));

export default YearTransactionStore;
