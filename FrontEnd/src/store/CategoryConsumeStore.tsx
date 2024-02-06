import { create } from "zustand";

interface CategoryConsume {
  memberId: number;
  categoryMonthlyConsumeList: CategoryMonthlyConsume[];

  setMemberId: (memberId: number) => void;
  setCategoryMonthlyConsumeList: (
    categoryMonthConsumeList: CategoryMonthlyConsume[]
  ) => void;

  selectedMonth: number;
  setSelectedMonth: (selectedMonth: number) => void;

  consumeDataList: number[];
  consumeLabelList: string[];
  setConsumeDataList: (consumeDataList: number[]) => void;
  setConsumeLabelList: (consumeLabelList: string[]) => void;

  colorList: string[];
  setColorList: (colorList: string[]) => void;
}

interface CategoryMonthlyConsume {
  month: number;
  monthlyEntireConsume: number;
  categoryMonthlyConsumeDetails: CategoryMonthlyConsumeDetail[];
}

interface CategoryMonthlyConsumeDetail {
  categoryName: string;
  monthlyConsumePerCategory: number;
}

const CategoryConsumeStore = create<CategoryConsume>((set) => ({
  memberId: 0,
  categoryMonthlyConsumeList: [],

  setMemberId: (memberId: number) => set({ memberId }),
  setCategoryMonthlyConsumeList: (
    categoryMonthlyConsumeList: CategoryMonthlyConsume[]
  ) => set({ categoryMonthlyConsumeList }),

  selectedMonth: 12,
  setSelectedMonth: (selectedMonth: number) => set({ selectedMonth }),
  consumeDataList: [],
  consumeLabelList: [],
  setConsumeDataList: (consumeDataList: number[]) => set({ consumeDataList }),
  setConsumeLabelList: (consumeLabelList: string[]) =>
    set({ consumeLabelList }),

  colorList: [
    "#172554",
    "#1e3a8a",
    "#1e40af",
    "#1d4ed8",
    "#2563eb",
    "#3b82f6",

    "#60a5fa",
    "#93c5fd",
    "#bfdbfe",
    "#dbeafe",
    "#eff6ff",
    "#7dd3fc",
  ],
  setColorList: (colorList: string[]) => set({ colorList }),
}));

export default CategoryConsumeStore;
