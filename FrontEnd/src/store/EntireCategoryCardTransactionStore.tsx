import { create } from "zustand";
import { MonthlyTransactionDetails } from "../types/type.d";

interface categoryConsume {
  categoryName: string;
  categoryConsume: number;
}
interface EntireCategoryCardTransaction {
  memberId: number;
  month: number;
  entireCategoryConsume: number;
  categoryConsumeList: categoryConsume[];

  setMemberId: (memberId: number) => void;
  setMonth: (month: number) => void;
  setEntireCategoryConsume: (entireCategoryConsume: number) => void;
  setCategoryConsumeList: (categoryConsumeList: categoryConsume[]) => void;
}

const EntireCategoryCardTransactionStore =
  create<EntireCategoryCardTransaction>((set) => ({
    memberId: 1,
    month: 12,
    entireCategoryConsume: 0,
    categoryConsumeList: [],

    setMemberId: (memberId: number) => set({ memberId }),
    setMonth: (month: number) => set({ month }),
    setEntireCategoryConsume: (entireCategoryConsume: number) =>
      set({ entireCategoryConsume }),
    setCategoryConsumeList: (categoryConsumeList: categoryConsume[]) =>
      set({ categoryConsumeList }),
  }));

export default EntireCategoryCardTransactionStore;
