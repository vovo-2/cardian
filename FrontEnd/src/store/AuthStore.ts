import { create } from "zustand";
import { createJSONStorage, persist } from "zustand/middleware";

interface AuthState {
  memberId: number | null;
  name: string;
  isLoggedIn: boolean;
  login: (memberId: number, name: string) => void;
  logout: () => void;
}

const useAuthStore = create<AuthState>()(
  persist(
    (set) => ({
      memberId: null,
      name: "",
      isLoggedIn: false,
      login: (memberId: number, name: string) => set({ memberId, isLoggedIn: true, name }),
      logout: () => set({ memberId: null, name: "", isLoggedIn: false }),
    }),
    {
      name: "auth",
      storage: createJSONStorage(() => sessionStorage),
    }
  )
);

export default useAuthStore;
