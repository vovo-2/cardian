import { create } from "zustand";
import { CardTransactionMonthlyListProps } from "../types/type.d";

interface EntireCardTransaction {
  memberId: number;
  entireMonthlyTransactionList: CardTransactionMonthlyListProps[];

  setMemberId: (memberId: number) => void;
  setEntireMonthlyTransactionList: (
    item: CardTransactionMonthlyListProps[]
  ) => void;
}

const EntireMonthlyCardTransactionStore = create<EntireCardTransaction>(
  (set) => ({
    memberId: 1,
    entireMonthlyTransactionList: [],

    setMemberId: (memberId: number) => set({ memberId }),
    setEntireMonthlyTransactionList: (
      entireMonthlyTransactionList: CardTransactionMonthlyListProps[]
    ) => set({ entireMonthlyTransactionList }),
  })
);

export default EntireMonthlyCardTransactionStore;
