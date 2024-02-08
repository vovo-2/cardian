import { create } from "zustand";
import { MonthlyTransactionDetails } from "../types/type.d";

interface CategoryTransaction {
  categoryName: string;
  categoryConsume: number;
  monthlyTransactionDetailsList: MonthlyTransactionDetails[];
}
interface EntireCategoryCardTransaction {
  memberId: number;
  month: number;
  entireCategoryConsume: number;
  categoryTransactionList: CategoryTransaction[];

  setMemberId: (memberId: number) => void;
  setMonth: (month: number) => void;
  setEntireCategoryConsume: (entireCategoryConsume: number) => void;
  setCategoryTransactionList: (
    categoryTransactionList: CategoryTransaction[]
  ) => void;
}

const EntireCategoryCardTransactionStore =
  create<EntireCategoryCardTransaction>((set) => ({
    memberId: 1,
    month: 12,
    entireCategoryConsume: 0,
    categoryTransactionList: [],

    setMemberId: (memberId: number) => set({ memberId }),
    setMonth: (month: number) => set({ month }),
    setEntireCategoryConsume: (entireCategoryConsume: number) =>
      set({ entireCategoryConsume }),
    setCategoryTransactionList: (
      categoryTransactionList: CategoryTransaction[]
    ) => set({ categoryTransactionList }),
  }));

export default EntireCategoryCardTransactionStore;
