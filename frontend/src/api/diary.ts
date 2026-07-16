import apiClient from './client'

export interface DiaryEntry {
  id: number
  title: string
  content: string
  createdAt: string
  updatedAt: string
}

export interface DiaryPayload {
  title: string
  content: string
}

export async function fetchDiaryList(): Promise<DiaryEntry[]> {
  const { data } = await apiClient.get<DiaryEntry[]>('/api/v1/diary')
  return data
}

export async function fetchDiaryDetail(id: number | string): Promise<DiaryEntry> {
  const { data } = await apiClient.get<DiaryEntry>(`/api/v1/diary/${id}`)
  return data
}

export async function createDiaryEntry(payload: DiaryPayload): Promise<DiaryEntry> {
  const { data } = await apiClient.post<DiaryEntry>('/api/v1/diary', payload)
  return data
}

export async function updateDiaryEntry(id: number, payload: DiaryPayload): Promise<DiaryEntry> {
  const { data } = await apiClient.put<DiaryEntry>(`/api/v1/diary/${id}`, payload)
  return data
}

export async function deleteDiaryEntry(id: number): Promise<void> {
  await apiClient.delete(`/api/v1/diary/${id}`)
}
