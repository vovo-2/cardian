import { create } from "zustand";
import { CardTransactionMonthlyListProps } from "../types/type.d";

interface CategoryEntireTransaction {
  categoryName: string;
  categoryMonthlyTransactionList: CardTransactionMonthlyListProps[];
}

interface EntireCategoryCardTransaction {
  memberId: number;
  categoryEntireTransactionList: CategoryEntireTransaction[];

  setMemberId: (memberId: number) => void;
  setCategoryEntireTransactionList: (
    categoryEntireTransactionList: CategoryEntireTransaction[]
  ) => void;
}

const EntireCategoryCardTransactionStore =
  create<EntireCategoryCardTransaction>((set) => ({
    memberId: 1,
    categoryEntireTransactionList: [],

    setMemberId: (memberId: number) => set({ memberId }),
    setCategoryEntireTransactionList: (
      categoryEntireTransactionList: CategoryEntireTransaction[]
    ) => set({ categoryEntireTransactionList }),
  }));

export default EntireCategoryCardTransactionStore;
