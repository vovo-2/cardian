import { create } from "zustand";

interface MonthlyCategoryInfo {
  // Graph
  nowMonthConsumeList: number[];
  lastMonthConsumeList: (number | undefined)[];

  nowMonthLabelList: string[];
  lastMonthLabelList: string[];

  colorList: string[];

  setNowMonthConsumeList: (nowMonthConsumeList: number[]) => void;
  setLastMonthConsumeList: (
    lastMonthConsumeList: (number | undefined)[]
  ) => void;

  setNowMonthLabelList: (nowMonthLabelList: string[]) => void;
  setLastMonthLabelList: (lastMonthLabelList: string[]) => void;

  // Selector
  selectedMonth: number;
  selectedTopNCategory: number;

  setSelectedMonth: (selectedMonth: number) => void;
  setSelectedTopNCategory: (selectedTopNCategory: number) => void;
}

const MonthlyCategoryInfoStore = create<MonthlyCategoryInfo>((set) => ({
  selectedMonth: 12,
  setSelectedMonth: (selectedMonth: number) => set({ selectedMonth }),

  selectedTopNCategory: 4,
  setSelectedTopNCategory: (selectedTopNCategory: number) =>
    set({ selectedTopNCategory }),

  nowMonthConsumeList: [],
  setNowMonthConsumeList: (nowMonthConsumeList: number[]) =>
    set({ nowMonthConsumeList }),

  lastMonthConsumeList: [],
  setLastMonthConsumeList: (lastMonthConsumeList: (number | undefined)[]) =>
    set({ lastMonthConsumeList }),

  nowMonthLabelList: [],
  setNowMonthLabelList: (nowMonthLabelList: string[]) =>
    set({ nowMonthLabelList }),

  lastMonthLabelList: [],
  setLastMonthLabelList: (lastMonthLabelList: string[]) =>
    set({ lastMonthLabelList }),

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
}));

export default MonthlyCategoryInfoStore;
